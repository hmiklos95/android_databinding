package hu.miklos.databinding_test;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

import hu.miklos.databinding_test.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static MainActivity instance;
    public MainActivity() {
        instance = this;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("miki", "központikoli", "test@example.com", 22));
        persons.add(new Person("kapitány", "központikoli", "test@example.com", 23));
        persons.add(new Person("kálmán", "központikoli", "test@example.com", 23));

        binding.setPersons(persons);
    }

    public static MainActivity getInstance() {
        return instance;
    }
}
