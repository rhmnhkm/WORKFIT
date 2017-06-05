package com.example.workfit.Activities;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.DialogInterface;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.workfit.workfitapps.R;
import com.pkmmte.view.CircularImageView;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class Register extends AppCompatActivity {

    private Uri mCropImageUri;
    private Bitmap cropped;
    private String username, gender="Male";
    private int height, weight, error = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText editUsername = (EditText) findViewById(R.id.username);
        final EditText editHeight = (EditText) findViewById(R.id.editText6);
        final EditText editWeight = (EditText) findViewById(R.id.editText7);

        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(Register.this);
        alertDialog.setTitle("Ow snap!");
        alertDialog.setMessage("Please fill in all the required information");
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface d, int which) {
                d.dismiss();
            }
        });

        Button nextButton = (Button)findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (cropped==null){
                    error++;
                }

                if (editUsername.getText().toString().trim()==null) {
                    error++;
                } else {
                    username = editUsername.getText().toString();
                }

                if (editWeight.getText().toString().trim()==null) {
                    error++;
                } else {
                    weight = !editWeight.getText().toString().trim().equals("")?
                            Integer.parseInt(editWeight.getText().toString()):error++;
                }

                if (editHeight.getText().toString().trim()==null) {
                    error++;
                } else {
                    height = !editHeight.getText().toString().trim().equals("")?
                            Integer.parseInt(editHeight.getText().toString()):error++;
                }

                if(error==0) {

                    Intent intent = new Intent(Register.this, HomeActivity.class);

                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    cropped.compress(Bitmap.CompressFormat.JPEG, 60, stream);
                    byte[] bytes = stream.toByteArray();

                    Bundle extras = new Bundle();
                    extras.putString("USERNAME", username);
                    extras.putInt("HEIGHT", height);
                    extras.putInt("WEIGHT", weight);
                    extras.putString("GENDER", gender);
                    extras.putByteArray("BMP",bytes);
                    intent.putExtra("Bundle", extras);
                    startActivity(intent);

                } else {
                    alertDialog.show();
                    error = 0;
                }
            }
        });
   }


    //Imported Library
    /**
     * On load image button click, start pick  image chooser activity.
     */
    public void onLoadImageClick(View view) {
        CropImage.activity(null)
                //.setMaxCropResultSize(1000,1000)
                .setGuidelines(CropImageView.Guidelines.ON)
                .setCropShape(CropImageView.CropShape.OVAL)
                .setFixAspectRatio(true)
                .setBackgroundColor(Color.parseColor("#CC2E0927"))
                .start(this);
    }

    @Override
    protected void onActivityResult(int  requestCode, int resultCode, Intent data) {

        // handle result of CropImageActivity
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                ImageView placeholder = (ImageView)findViewById(R.id.profilePicture);
                CircularImageView imageView = (CircularImageView)findViewById(R.id.profilePicture2);
                TextView uploadImageButton = (TextView)findViewById(R.id.uploadimage);
                TextView maxImageText = (TextView)findViewById(R.id.textView14);

                imageView.setImageURI(result.getUri());
                cropped = ((BitmapDrawable)imageView.getDrawable()).getBitmap();


                imageView.setImageBitmap(cropped);
                placeholder.setVisibility(GONE);
                imageView.setVisibility(VISIBLE);
                uploadImageButton.setVisibility(GONE);
                maxImageText.setTextColor(Color.parseColor("#002E0927"));

                Toast.makeText(this, "Set image successful", Toast.LENGTH_LONG).show();
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Toast.makeText(this, "Cropping failed",Toast.LENGTH_LONG).show();
            }
        }
    }
}

/****/
