package com.kawnayeen.androidutilexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.kawnayeen.intentutil.ImagePicker;

import java.io.File;

public class MultipleImagePicking extends AppCompatActivity {

    Button firstImageBtn;
    Button secondImageBtn;
    Button thirdImageBtn;

    TextView firstImageText;
    TextView secondImageText;
    TextView thirdImageText;

    File firstImage = null;
    File secondImage = null;
    File thirdImage = null;

    String firstImageName = "first-image.jpg";
    String secondImageName = "second-image.jpg";
    String thirdImageName = "third-image.jpg";

    private static final int PICK_FIRST_IMAGE = 235;
    private static final int PICK_SECOND_IMAGE = 236;
    private static final int PICK_THIRD_IMAGE = 237;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_image_picking);

        firstImageBtn = findViewById(R.id.takePicOne);
        secondImageBtn = findViewById(R.id.takePicTwo);
        thirdImageBtn = findViewById(R.id.takePicThree);

        firstImageText = findViewById(R.id.descriptionOne);
        secondImageText = findViewById(R.id.descriptionTwo);
        thirdImageText = findViewById(R.id.descriptionThree);

        firstImageBtn.setOnClickListener(view -> startImagePickingIntent(PICK_FIRST_IMAGE, firstImageName));
        secondImageBtn.setOnClickListener(view -> startImagePickingIntent(PICK_SECOND_IMAGE, secondImageName));
        thirdImageBtn.setOnClickListener(view -> startImagePickingIntent(PICK_THIRD_IMAGE, thirdImageName));
    }

    private void startImagePickingIntent(int code, String fileName) {
        Intent chooseImageIntent = ImagePicker.getPickImageIntent(this, fileName);
        startActivityForResult(chooseImageIntent, code);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case PICK_FIRST_IMAGE:
                firstImage = ImagePicker.getImageFileToUpload(this, resultCode, data);
                updateDescription();
                break;
            case PICK_SECOND_IMAGE:
                secondImage = ImagePicker.getImageFileToUpload(this, resultCode, data);
                updateDescription();
                break;
            case PICK_THIRD_IMAGE:
                thirdImage = ImagePicker.getImageFileToUpload(this, resultCode, data);
                updateDescription();
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
                break;
        }
    }

    private void updateDescription() {
        String firstImageDescription = firstImage == null ? "Null image" : "Name: " + firstImage.getName() + " -- Length: " + firstImage.length();
        firstImageText.setText(firstImageDescription);
        String secondImageDescription = secondImage == null ? "Null image" : "Name: " + secondImage.getName() + " -- Length: " + secondImage.length();
        secondImageText.setText(secondImageDescription);
        String thirdImageDescription = thirdImage == null ? "Null image" : "Name: " + thirdImage.getName() + " -- Length: " + thirdImage.length();
        thirdImageText.setText(thirdImageDescription);
    }
}
