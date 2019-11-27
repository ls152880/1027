package com.lfz.facotry;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.config.Ini;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.config.IniFilterChainResolverFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.lfz.entity.Menu;
import com.lfz.entity.Role;
import com.lfz.service.MenuService;

public class MyShiroFilterFactoryBean extends ShiroFilterFactoryBean {

	// ע��
	@Autowired
	private MenuService ms;

	private static final String ROLE_STRING = "roles[{0}]";

	public static String filterChainDefinitions = "";

	@Override
	public void setFilterChainDefinitions(String definitions) {
		System.out.println("$$$$$$$$$$$$$$");

		filterChainDefinitions = definitions;
		Ini ini = new Ini();
		ini.load(definitions);
		// did they explicitly state a 'urls' section? Not necessary, but just
		// in case:
		Ini.Section section = ini.getSection(IniFilterChainResolverFactory.URLS);
		if (CollectionUtils.isEmpty(section)) {
			// no urls section. Since this _is_ a urls chain definition
			// property, just assume the
			// default section contains only the definitions:
			section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
		}

		Map<String, String[]> permsMap = new HashMap<String, String[]>();
		// ��ʼȥ���ݿ��в�ѯĳ��URL��Ӧ�Ľ�ɫ
		List<Menu> menus = ms.findMenuAll();
		// ����������Ĳ˵�
		for (Menu menu : menus) {
			// ��ȡ�˵���Ӧ�Ľ�ɫ
			List<Role> rs = menu.getRoles();
			// �����ַ���������Ž�ɫ��
			String[] roleNames = new String[rs.size()];
			for (int i = 0; i < rs.size(); i++) {
				// ��ÿ��role��rolenameȡ���ŵ�roleNames����
				roleNames[i] = rs.get(i).getRolename();
			}
			//
			permsMap.put(menu.getMlink(), roleNames);
		}
		// ����map
		for (String url : permsMap.keySet()) {
			System.out.println("·��" + url);

			// ͨ��·����ȡ��Ӧ��ɫ
			String[] roles = permsMap.get(url);
			StringBuilder sb = new StringBuilder();
			// ����ÿ��URL��ȡ�õĽ�ɫ��Ȼ��׷���ں��棬ÿ��һ����ɫ��һ������
			for (String role : roles) {
				sb.append(role).append(",");
			}

			// admin,test,guest,
			// ��ȡ���һ��,
			String str = sb.substring(0, sb.length() - 1);
			System.out.println("str:" + str + "%%%%%%%%%%%");
			System.out.println(permsMap + "************");
			// �Ѷ�Ӧ��·���Լ�Ȩ�޷ŵ�section�У�MessageFormat.format(ROLE_STRING, str)���滻ռλ��
			System.out.println("MessageFormat.format(ROLE_STRING, str):" + MessageFormat.format(ROLE_STRING, str));
			section.put(url, MessageFormat.format(ROLE_STRING, str));
		}
		section.put("/**", "authc");// ��֤�������ط���
		setFilterChainDefinitionMap(section);
	}

}
