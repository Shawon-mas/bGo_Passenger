package com.app.bGoPassenger.view.passengerProfileUi;

import static android.app.Activity.RESULT_OK;
import static com.app.bGoPassenger.utilites.Constants.KEY_IMAGE_URI;
import static com.app.bGoPassenger.utilites.Constants.KEY_USER_ID;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.bGoPassenger.R;
import com.app.bGoPassenger.databinding.FragmentSelfieInfoBinding;
import com.app.bGoPassenger.utilites.PreferenceManager;
import com.github.dhaval2404.imagepicker.ImagePicker;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class SelfieInfo extends Fragment {
    private FragmentSelfieInfoBinding binding;
    private PreferenceManager preferenceManager;
    private String encodedImage;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentSelfieInfoBinding.inflate(getLayoutInflater());
        preferenceManager=new PreferenceManager(getActivity());

        pickImage();
        return binding.getRoot();

    }
    private String encodeImage(Bitmap bitmap)
    {
        int previewWidth=150;
        int previewHeight=bitmap.getHeight()*previewWidth/bitmap.getWidth();
        Bitmap previewBitmap=Bitmap.createScaledBitmap(bitmap,previewWidth,previewHeight,false);
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        previewBitmap.compress(Bitmap.CompressFormat.JPEG,50,byteArrayOutputStream);
        byte[] bytes=byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(bytes,Base64.DEFAULT);

    }
    private void pickImage() {
        binding.addImage.setOnClickListener(v -> {
            Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            pickImage.launch(intent);
        });

    }
    private final ActivityResultLauncher<Intent> pickImage=registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode()==RESULT_OK)
                {
                    if (result.getData()!=null)
                    {
                        Uri imageUri=result.getData().getData();
                        try {

                            InputStream inputStream=getContext().getContentResolver().openInputStream(imageUri);
                            Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
                            binding.profileImage.setImageBitmap(bitmap);
                            binding.addImage.setVisibility(View.GONE);
                            encodedImage=encodeImage(bitmap);
                            preferenceManager.putString(KEY_USER_ID,encodedImage);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
    );

}