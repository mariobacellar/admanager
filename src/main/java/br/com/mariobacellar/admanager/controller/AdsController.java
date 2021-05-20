package br.com.mariobacellar.admanager.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.mariobacellar.admanager.util.Util;

import java.io.File;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/api/admanager")
public class AdsController {


	@RequestMapping("")
	@ResponseBody
	public String home() {
		return 	"{"
				+ "\"autor\":\"https://www.linkedin.com/in/mariobacellar/\","
				+ "\"gtihub\":\"https://github.com/mariobacellar/admanager\","
				+ "\"resources\":["						
				+     			"{"	
				+ 					"\"Advertisement\":\" Advertisement management\","
				+ 					"\"URL\":\"https://macro-admanager.herokuapp.com/api/admanager/ads \""
				+ 				"}"
				+ 			"]" 
				+"}";
	}

	@RequestMapping("/ads")
	@ResponseBody
	public String getAds() {
		return    getJSON_Ads( );
	}

	
	private String getJSON_Ads() {
		try {
			String		filename= "src/main/resources/Ads.json";
			File		file	= new File(filename);
			String[]	json	= Util.doReadLines(file);
			String 		jsonStr = Util.convert2String(json); 
			return 	jsonStr;
		} catch (Exception e) {
			return "null";		}
	}
	
}
