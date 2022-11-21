# IT481_Assignment9

Updated the following since assignment 3:

Fixed some bugs leaving buttons enabled after user has logged in once and disconnected.

New feature: Lock out timer
Added failed login attempt counters and a max login attempt limit.
After 5 unsuccessful login attempts in a row, all buttons are disabled and a lock out timer will start.
Users may re-login after the timer finishes.

New feature: Password Masking.
Changed user password field to using jpasswordfields for masking.
Passwords are represented as asterisks "*" passwords can no longer be copy or paste.

Minimum password length has been increased to 12 characters.

The jdbc sql server connection is now encrypted.
