package br.com.mariobacellar.admanager.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.mariobacellar.admanager.util.Util;

import java.io.File;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
				+ 				"},"
				+     			"{"	
				+ 					"\"Advertisement\":\" Advertisement management\","
				+ 					"\"URL\":\"https://macro-admanager.herokuapp.com/api/admanager/ads/1 \""
				+ 				"}"
				+ 			"]" 
				+"}";
	}

	@RequestMapping("/ads")
	@ResponseBody
	public String getAds() {
		return    getJSON_Ads( );
	}

	@RequestMapping("/ads/{id}")
	@ResponseBody
	public String getAds(@PathVariable String id){
		System.out.println("id=("+id+")");
		return    getJSON_Ads(id);
	}
	
	private String getJSON_Ads() {
		return getJSON_Ads("");
	}

	private String getJSON_Ads(String id) {
		try {
			String		filename= "src/main/resources/Ads"+id+".json";
			
			System.out.println("filename=("+filename+")");
			File		file	= new File(filename);
			String[]	json	= Util.doReadLines(file);
			String 		jsonStr = Util.convert2String(json); 
			return 	jsonStr;
		} catch (Exception e) {
			return "null";		}
	}
	
}
