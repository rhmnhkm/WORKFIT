package com.example.workfit.Activities;

import android.Manifest;
import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.system.ErrnoException;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.workfit.workfitapps.R;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Register extends AppCompatActivity {

    private Uri mCropImageUri;
    private Bitmap cropped;
    private String username, gender="Male";
    private int height, weight, steps = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText editUsername = (EditText) findViewById(R.id.username);
        final EditText editHeight = (EditText) findViewById(R.id.editText6);
        final EditText editWeight = (EditText) findViewById(R.id.editText7);

        editUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().trim().length() == 0) {
                    Toast.makeText(Register.this, "Text can not be empty..",
                            Toast.LENGTH_SHORT).show();
                } else {
                    username = charSequence.toString().trim();
                    steps++;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        editHeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().trim().length() == 0) {
                    Toast.makeText(Register.this, "Height can not be empty..",
                            Toast.LENGTH_SHORT).show();
                } else {
                    height = Integer.parseInt(charSequence.toString().trim());
                    steps++;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        editWeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().trim().length() == 0) {
                    Toast.makeText(Register.this, "Weight can not be empty..",
                            Toast.LENGTH_SHORT).show();
                } else {
                    weight = Integer.parseInt(charSequence.toString().trim());
                    steps++;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        }

    public void onNextButtonClick(View view){
        Intent intent = new Intent(Register.this, HomeActivity.class);

                    /*ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    cropped.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    byte[] byteArray = stream.toByteArray();*/

                    Bundle extras = new Bundle();
                    extras.putString("ID_USERNAME", username);
                    extras.putInt("ID_HEIGHT", height);
                    extras.putInt("ID_WEIGHT", weight);
                    extras.putString("ID_GENDER", gender);
                    //extras.putByteArray("ID_AVATAR", byteArray);
                    intent.putExtra("Bundle", extras);

        startActivity(intent);
    }


    //Imported Library
    /**
     * On load image button click, start pick  image chooser activity.
     */
    public void onLoadImageClick(View view) {
        CropImage.activity(null)
                .setMaxCropResultSize(1000,1000)
                .setGuidelines(CropImageView.Guidelines.ON)
                .setCropShape(CropImageView.CropShape.OVAL)
                .setFixAspectRatio(true)
                .setBackgroundColor(Color.parseColor("#2E0927"))
                .start(this);
    }

    /**
     * Crop the image and set it back to the  cropping view.
     */
    /*public void onCropImageClick(View view) {
        cropped =  mCropImageView.getCroppedImage(500, 500);
        if (cropped != null) {
            mCropImageView.setImageBitmap(cropped);
            ImageView profilePicture = (ImageView) findViewById(R.id.profilePicture);
            profilePicture.setImageBitmap(getResizedBitmap(cropped,100,100));
        }
    }*/

    @Override
    protected void onActivityResult(int  requestCode, int resultCode, Intent data) {

        // handle result of CropImageActivity
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                ImageView placeholder = (ImageView)findViewById(R.id.profilePicture);
                ImageView imageView = (ImageView)findViewById(R.id.profilePicture2);
                imageView.setImageURI(result.getUri());
                cropped = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
                Bitmap.createScaledBitmap(cropped, 300, 300, true);
                imageView.setImageBitmap(cropped);
                placeholder.setVisibility(View.GONE);
                imageView.setVisibility(View.VISIBLE);
                Toast.makeText(this, "Cropping successful", Toast.LENGTH_LONG).show();
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Toast.makeText(this, "Cropping failed",Toast.LENGTH_LONG).show();
            }
        }

        /*if (resultCode == Activity.RESULT_OK) {
            Uri imageUri =  getPickImageResultUri(data);

            // For API >= 23 we need to check specifically that we have permissions to read external storage,
            // but we don't know if we need to for the URI so the simplest is to try open the stream and see if we get error.
            boolean requirePermissions = false;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
                    checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED &&
                    isUriRequiresPermissions(imageUri)) {

                // request permissions and handle the result in onRequestPermissionsResult()
                requirePermissions = true;
                mCropImageUri = imageUri;
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
            }

            if (!requirePermissions) {
                mCropImageView.setImageUriAsync(imageUri);
            }
        }*/
    }

}

/****/
