package com.imooc.security.crc;

import java.util.zip.CRC32;

public class ImoocCRC {

	public static void main(String[] args) {
		String src = "imooc security crc";
		CRC32 crc = new CRC32();
		crc.update(src.getBytes());
		String hex = Long.toHexString(crc.getValue());
		System.out.println("jdk crc32 : " + hex);
	}

}
