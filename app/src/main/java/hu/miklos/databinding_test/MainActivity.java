package hu.miklos.databinding_test;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.common.collect.Lists;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import hu.miklos.databinding_test.databinding.ActivityMainBinding;
import layout.WarningFragment;

public class MainActivity extends AppCompatActivity implements WarningFragment.OnFragmentInteractionListener{

    private static MainActivity instance;

    private ActivityMainBinding binding;
    public MainActivity() {
        instance = this;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("miki", "központikoli", "test@example.com", 22));
        persons.add(new Person("kapitány", "központikoli", "test@example.com", 23));
        persons.add(new Person("kálmán", "központikoli", "test@example.com", 23));

        binding.setPersons(persons);
        binding.setWarningShown(false);
    }

    public void openFileChoose(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("file/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        // 999 = request code, this is for the file chooser request
        startActivityForResult(intent, 999);
    }

    public void showWarning(View view) {
        getSupportFragmentManager().beginTransaction().add(WarningFragment.createForActivity(this), "warning").commit();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 999) {
            String path = data.getDataString();

            File file = new File(path);

            //TODO: send file to the api.
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public static MainActivity getInstance() {
        return instance;
    }

    @Override
    public void onFragmentInteraction(boolean fragmentShown) {
        binding.setWarningShown(fragmentShown);
        binding.executePendingBindings();
    }
}
