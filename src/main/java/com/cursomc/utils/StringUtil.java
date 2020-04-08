package com.cursomc.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {
	
	
	public static List<Integer> decodeToIntList(String s){
		
		return Arrays.asList(s.split(",")).stream().map(element -> Integer.parseInt(element)).collect(Collectors.toList());
	}
	
	public static List<Integer> decodeToIntList(String s, String separador){
		
		return Arrays.asList(s.split(separador)).stream().map(element -> Integer.parseInt(element)).collect(Collectors.toList());
	}
	

}
