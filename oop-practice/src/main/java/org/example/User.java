package org.example;

public class User {
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password = null;

    public void initPassword(PasswordGenerator passwordGenerator) {
        // to-be
        String randomPassword = passwordGenerator.generatePassword();
        System.out.println("randomPassword = " + randomPassword);
        /**
         *
         * 비밀번호는 최소 8자 이상 12자 이하여야 한다.
         * */
        if(randomPassword.length() >= 8 && randomPassword.length() <= 12){
            System.out.println("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
            this.password = randomPassword;
        }
        // as-is
        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();

    }


}
