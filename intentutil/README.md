Image Picker Intent
===========

Very simple use case --

```
Intent chooseImageIntent = ImagePicker.getPickImageIntent(this);
startActivityForResult(chooseImageIntent, REQUEST_CODE);
```

Once the intent is done, to get bitmap, try following :--

```
Bitmap bitmap = ImagePicker.getImageFromResult(this, resultCode, data);
```

and to get the file for uploading at server :--

```
File file = ImagePicker.getImageFileToUpload(this, resultCode, data);
```

Assuming `protected void onActivityResult(int requestCode, int resultCode, Intent data)`

Permissions
------------
Add the following permission in your manifest file <br/>
`<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />`

For android version `marshmallow` and above, check whether the permission is granted or not before calling startActivityForResult

You can check example usages [here](https://github.com/kawnayeen/AndroidUtil/blob/master/app/src/main/java/com/kawnayeen/androidutilexample/MainActivity.java)
