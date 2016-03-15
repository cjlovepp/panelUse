package com.src.service;

import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.src.entity.PayView;
import com.src.entity.User;

public class DataService {
	
	final String userPath = this.getClass().getClassLoader().getResource("user.xml").toString();
	final String dataPath = this.getClass().getClassLoader().getResource("data.xml").toString();
	
	public Element getXmlRoot(){
		SAXReader reader = new SAXReader();
		Document document;
		try {
			document = reader.read(new File(userPath.substring(6, userPath.length())));
			Element root = document.getRootElement();
			return root;
		} catch (DocumentException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 读取用户信息
	 * @return
	 */
	public User initUserPanel(){
		String name = "";
		String password = "";
		Element root = getXmlRoot();
		Element nameElement = root.element("userName");
		Element passwordElement = root.element("password");
		name = nameElement.getText();
		password = passwordElement.getText();
		User user = new User(name, password);
		return user;
		
	}
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user){
		boolean result=false;
		SAXReader reader = new SAXReader();
		Document document;
		try {
			document = reader.read(new File(userPath.substring(6, userPath.length())));
			Element root = document.getRootElement();
			Element nameElement = root.element("userName");
			Element passwordElement = root.element("password");
			nameElement.setText(user.getName());
			passwordElement.setText(user.getPassword());
			
			XMLWriter writer = new XMLWriter(new FileWriter(new File(userPath.substring(6, userPath.length()))));  
            writer.write(document);
            writer.close(); 
			
			result = true;
			return result;
		} catch (Exception e) {
			return result;
		}
	}
	
	public boolean addPayView(PayView payView){
		boolean result=false;
		SAXReader reader = new SAXReader();
		Document document;
		try {
			document = reader.read(new File(dataPath.substring(6, userPath.length())));
			Element root = document.getRootElement();
			List list = root.content();
			Element element = DocumentHelper.createElement("item");
			element.addAttribute("id", payView.getId());
			element.addAttribute("date", payView.getDate());
			element.addAttribute("info", payView.getInfo());
			list.add(0, element);
			XMLWriter writer = new XMLWriter(new FileWriter(new File(dataPath.substring(6, userPath.length()))));  
            writer.write(document);
            writer.close(); 
			
			result = true;
			return result;
		} catch (Exception e) {
			return result;
		}
	}
	
	
	

	public static void main(String[] args) {
		DataService dataService = new DataService();
		PayView payView = new PayView("111111111111", new Date().toString(), "aaaaaaaaaa");
		
		dataService.addPayView(payView);
	}
}
