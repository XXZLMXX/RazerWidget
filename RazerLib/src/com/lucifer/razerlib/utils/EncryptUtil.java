package com.lucifer.razerlib.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;
import android.util.Base64;



public class EncryptUtil
{
	private final static String DES = "DES";
	private static BASE64Encoder base64en = new BASE64Encoder();

	
	
	/**
	 * Description 根据键值进行加密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String data, String key) throws Exception
	{
		byte[] bt = encrypt(data.getBytes(), key.getBytes());
		String strs = new BASE64Encoder().encode(bt);
		// String strs = Base64.encodeToString(bt, Base64.DEFAULT);
		return strs;
	}

	
	
	/**
	 * Description 根据键值进行解密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	public static String decrypt(String data, String key) throws IOException,
			Exception
	{
		if (data == null)
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] buf = decoder.decodeBuffer(data);
		byte[] bt = decrypt(buf, key.getBytes());
		return new String(bt);
	}

	
	
	/**
	 * Description 根据键值进行加密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws Exception
	 */
	private static byte[] encrypt(byte[] data, byte[] key) throws Exception
	{
		// 生成一个可信任的随机数源
		SecureRandom sr = new SecureRandom();
		// 从原始密钥数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);
		// 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);
		// Cipher对象实际完成加密操作
		Cipher cipher = Cipher.getInstance(DES);
		// 用密钥初始化Cipher对象
		cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

		return cipher.doFinal(data);
	}

	
	
	/**
	 * Description 根据键值进行解密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws Exception
	 */
	private static byte[] decrypt(byte[] data, byte[] key) throws Exception
	{
		// 生成一个可信任的随机数源
		SecureRandom sr = new SecureRandom();
		// 从原始密钥数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);
		// 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);
		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance(DES);
		// 用密钥初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

		return cipher.doFinal(data);
	}

	
	
	private static byte[] iv =
	{ 'c', 'i', 'd', 't', 'e', 'c', 'h', '1' };

	public static String encryptDES(String encryptString, String encryptKey)
			throws Exception
	{
		IvParameterSpec zeroIv = new IvParameterSpec(iv);
		SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes(), "DES");
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
		byte[] encryptedData = cipher.doFinal(encryptString.getBytes());
		return base64en.encode(encryptedData);
	}


	
	/**
	 * MD5加密
	 */
	public static String md5(String string)
	{
		byte[] hash;
		try
		{
			hash = MessageDigest.getInstance("MD5").digest(
					string.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e)
		{
			throw new RuntimeException("Huh, MD5 should be supported?", e);
		} catch (UnsupportedEncodingException e)
		{
			throw new RuntimeException("Huh, UTF-8 should be supported?", e);
		}

		StringBuilder hex = new StringBuilder(hash.length * 2);
		for (byte b : hash)
		{
			if ((b & 0xFF) < 0x10)
				hex.append("0");
			hex.append(Integer.toHexString(b & 0xFF));
		}
		return hex.toString();
	}

	
	
	
	/**
	 * 返回可逆算法DES的密钥
	 * 
	 * @param key
	 *            前8字节将被用来生成密钥。
	 * @return 生成的密钥
	 * @throws Exception
	 */
	public static Key getDESKey(byte[] key) throws Exception
	{
		DESKeySpec des = new DESKeySpec(key);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		return keyFactory.generateSecret(des);
	}

	
	
	
	
}
