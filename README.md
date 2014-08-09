WADBCE
======

WhatsApp Database Copy Eraser

###Why would I want to erase my WhatsApp database?

WhatsApp makes a daily encrypted copy of you chat history and stores it on your device's external storage (`sdcard/WhatsApp/Databases`). This means that any app that has the `<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>` and `<uses-permission android:name="android.permission.GET_ACCOUNTS"/>` permission can get a hold of your chat history. WADBCE removes this copy and all the copies on the directory.


### It is encrypted, why should I care?

The algorithm WhatsApp used to generate the encryption key is known to be broken([md5](http://en.wikipedia.org/wiki/MD5)) and shouldn't be used. To proof the point, [this guy and his buddies](http://bas.bosschert.nl/steal-whatsapp-update/) bruted forced the key and made it public.

###So, how does WADBCE help me?

It is really simple. WADBCE monitors the directory where the copies of the databases are stored and deletes all files in that directory.

###Wait, you are deleting my chat history, I do not want to lose my chats!

Remember, this is a copy of your chat history, a backup. WhatsApp actually uses the databases that are sandboxed in the application package to retrieve and store your chats. 

###I see WhatsApp provides an option to back up my chat history, is this what these databases are? I should be able to just turn that off, right?

Yes, these are those databases. The problem is that WhatsApp stores them automatically and there is no way to turn this feature off. When you click on backup my chat history, it copies the databases at that specific moment; it generates a snapshot and stores it. By default, it also generates that copy everyday, even if you do not ask for it.
