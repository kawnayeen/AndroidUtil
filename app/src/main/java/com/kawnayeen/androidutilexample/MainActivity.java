package com.kawnayeen.androidutilexample;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.kawnayeen.intentutil.ImagePicker;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    Button pickImageBitmap;
    Button pickImageFile;
    ImageView bitmapView;
    TextView fileInfo;
    private static final int REQUEST_READ_STORAGE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pickImageBitmap = findViewById(R.id.pickImageBitmap);
        bitmapView = findViewById(R.id.pickedImage);
        pickImageFile = findViewById(R.id.pickImageFile);
        fileInfo = findViewById(R.id.imageFileInfo);
        pickImageBitmap.setOnClickListener(view -> onPickImage(PICK_IMAGE_BITMAP_ID));
        pickImageFile.setOnClickListener(view -> onPickImage(PICK_IMAGE_FILE_ID));
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private static final int PICK_IMAGE_BITMAP_ID = 234; // the number doesn't matter
    private static final int PICK_IMAGE_FILE_ID = 235;
    private int imageCode;

    public void onPickImage(int code) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                proceedToImagePicking(code);
            } else {
                imageCode = code;
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_READ_STORAGE);
            }
        } else {
            proceedToImagePicking(code);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_READ_STORAGE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                proceedToImagePicking(imageCode);
            }
        } else
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void proceedToImagePicking(int code) {
        bitmapView.setVisibility(View.GONE);
        fileInfo.setVisibility(View.GONE);
        Intent chooseImageIntent = ImagePicker.getPickImageIntent(this);
        startActivityForResult(chooseImageIntent, code);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case PICK_IMAGE_BITMAP_ID:
                bitmapView.setVisibility(View.VISIBLE);
                Bitmap bitmap = ImagePicker.getImageFromResult(this, resultCode, data);
                bitmapView.setImageBitmap(bitmap);
                break;
            case PICK_IMAGE_FILE_ID:
                fileInfo.setVisibility(View.VISIBLE);
                File file = ImagePicker.getImageFileToUpload(this, resultCode, data);
                fileInfo.setText("Path: " + file.getName() + ", size: " + file.length());
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
                break;
        }
    }
}
