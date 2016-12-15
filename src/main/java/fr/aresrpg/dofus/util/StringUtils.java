package fr.aresrpg.dofus.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {

	public static String[] split(String value, String separator) {
		String v = value;
		List<String> buf = new ArrayList<>();
		int index;
		while ((index = v.indexOf(separator)) != -1) {
			buf.add(v.substring(0, index));
			v = v.substring(index + 1);
		}
		buf.add(v);
		return buf.toArray(new String[buf.size()]);
	}

	public static String[][] splitArray(String[] split, String pattern) {
		String[][] buf = new String[split.length][];
		for (int i = 0; i < buf.length; i++)
			buf[i] = split[i].split(pattern);
		return buf;
	}

	public static String padLeft(String s, int size, char with) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size - s.length(); i++)
			sb.append(with);
		sb.append(s);
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(padLeft("9", 3, '0'));
	}
}
