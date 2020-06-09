/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.user_management.registration;

<<<<<<< HEAD
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
=======
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
>>>>>>> 78cce0831d3b822d2bb8fef0a2d705d2c0a4f087

/**
 *
 * @author Asus
 */
public class PasswordEncryptionAndDecryption {
<<<<<<< HEAD
    public String getEncryptedValue(String input){
            try{
                SecretKey key = generateKey();
                Cipher cp = Cipher.getInstance("AES");
                byte[] encryptedData = encryptString(input,key,cp);
                String encryptedString = new String(encryptedData);
                return encryptedString;
            }
            catch(Exception e){
                return null;
            }
        }
        
        public String getDecryptedValue(String input){
            try{
                byte[] toByte=input.getBytes();
                SecretKey key = generateKey();
                Cipher cp = Cipher.getInstance("AES");
                String decryptedValue = decryptString(toByte, key, cp);
                return decryptedValue;
            }
            catch(Exception e){
                return null;
            }
        }
    public SecretKey generateKey(){
        try{
            KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
            SecretKey myKey = keygenerator .generateKey();
            return myKey;
        }
        catch(Exception e){
            System.out.println("Error here");
            return null;
        }
    }
        
    public byte[] encryptString (String dataToEncrypt,SecretKey myKey,Cipher cipher){
        try{
//            System.out.println("Error here");
             byte[] text = dataToEncrypt.getBytes();
//             System.out.println("Error here");
             cipher.init(Cipher.ENCRYPT_MODE, myKey);
             byte[] textEncrypted = cipher.doFinal(text);
             return textEncrypted;
        }
        catch(Exception e){
//            System.out.println("encrypted");
            return null;
            
        }
    }
    public String decryptString (byte[] dataToDecrypt,SecretKey myKey,Cipher cipher){
        try{
            cipher.init(Cipher.DECRYPT_MODE, myKey);
            byte[] texDecrypted = cipher.doFinal(dataToDecrypt);
            String result = new String(texDecrypted);
            return result;
        }
        catch(Exception e){
            System.out.println("decrypted");
            return null;
        }
=======

    private static final String UNICODE_FORMAT = "UTF-8";
    String EncryptionType = "AES";

    private static final byte[] KEY_DATA = {
        (byte) 0x00, (byte) 0x01, (byte) 0x02, (byte) 0x03,
        (byte) 0x04, (byte) 0x05, (byte) 0x06, (byte) 0x07,
        (byte) 0x08, (byte) 0x09, (byte) 0x0A, (byte) 0x0B,
        (byte) 0x0C, (byte) 0x0D, (byte) 0x0E, (byte) 0x0F,};

    public String encryptPassword(String PasswordToEncrypt) throws UnsupportedEncodingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException {

        Cipher ciphertext;
        ciphertext = Cipher.getInstance(EncryptionType);

        SecretKey Ekey = new SecretKeySpec(KEY_DATA, EncryptionType);

        byte[] BeforeEncryption = PasswordToEncrypt.getBytes(UNICODE_FORMAT);
        ciphertext.init(Cipher.ENCRYPT_MODE, Ekey);
        byte[] AfterEncryption = ciphertext.doFinal(BeforeEncryption);

        String EncryptedPassword = new String(AfterEncryption);

        return EncryptedPassword;
    }

    public String decryptPassword(String PasswordToDecrypt) throws UnsupportedEncodingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException {

        Cipher ciphertext;
        ciphertext = Cipher.getInstance(EncryptionType);

        SecretKey Dkey = new SecretKeySpec(KEY_DATA, EncryptionType);

        byte[] BeforeDecryption = PasswordToDecrypt.getBytes(UNICODE_FORMAT);
        ciphertext.init(Cipher.DECRYPT_MODE, Dkey);
        byte[] AfterDecryption = ciphertext.doFinal(BeforeDecryption);

        String DecryptedPassword = new String(AfterDecryption);

        return DecryptedPassword;
>>>>>>> 78cce0831d3b822d2bb8fef0a2d705d2c0a4f087
    }
}
