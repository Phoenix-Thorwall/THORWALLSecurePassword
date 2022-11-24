public class SecurePassword {
    // instance variable
    private String password;

    // constructor
    public SecurePassword(String password) {
        this.password = password;
    }

    public void setPassword(String newPassword) {
        password = newPassword;
    }


    /* Returns true if password:
       - Is at least 8 characters long
       - Contains at least one uppercase letter
       - Contains at least one lowercase letter
       - Contains at least one numeric digit
       - Contains at least one of these "special symbols":  ! @ # $ % ^ & * ?
       Must satisfy ALL FIVE categories for password to be "secure"
       Return false if any of the above security requirements are not fulfilled.
    */
    public boolean isSecure() {
        if (isLongEnough() && containsUppercase() && containsLowercase() && containsDigit() && containsSpecialSymbol())
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    /* Returns a String that contains information about the security status of the
       current password.

       If isSecure() is true, this method returns the string "Password is secure"
       If isSecure() is false, this methods should return a single String that informs the
       user of which security requirements are not currently being met.

       For example, the password 3WrT6tH does not meet length or special symbol
       requirements, so this method should return the following String (using a line
       break \n):

       "The password must be at least 8 characters
        The password must contain a special symbol: ! @ # $ % ^ & * ?"
    */
    public String status() {
        String errors = "";
        String secure = "Password is secure";
        if (isSecure())
        {
            return secure;
        }
        else
        {
            if (isLongEnough() == false)
            {
                errors += "Password is not long enough \n";
            }
            if (containsUppercase() == false)
            {
                errors += "Password does not contain uppercase letters\n";
            }
            if (containsLowercase() == false)
            {
                errors += "Password does not contain lowercase letters\n";
            }
            if (containsDigit() == false)
            {
                errors += "Password does not contain digits\n";
            }
            if (containsSpecialSymbol() == false)
            {
                errors += "Password does not contain special characters\n";
            }
            return errors;
        }
    }



    // PRIVATE "HELPER" METHODS (marked "private" rather than "public" which means other
    // methods in this class can call these methods, but code outside of this class cannot)

    /* Returns true if the password’s length meets the minimum requirement of 8 characters
       and false otherwise.
     */
    private boolean isLongEnough()
    {
        if (password.length() <= 8)
        {
            return false;
        }
        else
        {
            return true;
        }
    }


    /* Returns true if the password has at least one uppercase letter and false otherwise.
     */
    private boolean containsUppercase() {
        /* this one is completed for you as a hint for how to do the others! */
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return checkString(upperCaseLetters);  // this method implemented below
    }


    /* Returns true if the password has at least one lowercase letter and false otherwise.
     */
    private boolean containsLowercase() {
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        return checkString(lowerCaseLetters);
    }


    /* Returns true if the password has at least one digit and false otherwise.
     */
    private boolean containsDigit() {
        boolean bool = true;
        String digits = "0123456789";
        String check = "";
        for (int i = 0; i < digits.length(); i++)
        {
            check.equals(digits.charAt(i));
            if (password.indexOf(check) > 0)
            {
                bool = true;
            }
            else
            {
                bool = false;
            }
        }
        return bool;
    }


    /* Returns true if the password has at least one of these special symbols:
       ! @ # $ % ^ & * ?    and false otherwise.
     */
    private boolean containsSpecialSymbol() {
        boolean bool = true;
        String special = "!@#$%^&*?";
        String check = "";
        for (int i = 0; i < special.length(); i++)
        {
            check.equals(special.charAt(i));
            if (password.indexOf(check) > 0)
            {
                bool = true;
            }
            else
            {
                bool = false;
            }
        }
        return bool;
    }

    /* Checks characterString to see if password contains at least one
       character from that string. Returns true if so, false otherwise.

       For example, if characterString is "ABCDEFGH" and password == "jbHFmfA"
       this method will find two occurrences (F and A) and return true, since two
       is at least one.  If characterString is "ABCDEFGH" and password == "xyz123"
       this method will return false, since password contains none of the characters in
        characterString.
     */
    private boolean checkString(String characterString) {
        boolean bool = true;
        String check = "";
        for (int i = 0; i < characterString.length(); i++)
        {
            check.equals(characterString.charAt(i));
            if (password.indexOf(check) > 0)
            {
                bool = true;
            }
            else
            {
                bool = false;
            }
        }
        return bool;
    }
}


