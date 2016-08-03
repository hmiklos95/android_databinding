package hu.miklos.databinding_test;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
;import java.util.List;

import hu.miklos.databinding_test.databinding.PersonlayoutBinding;

/**
 * Created by Miklós on 2016. 08. 03..
 */
public class BindingAdapters {
    @BindingAdapter("app:items")
    public static void entries(RecyclerView recyclerView, List persons) {
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.getInstance()));
        recyclerView.setAdapter(new SimpleArrayAdapter(persons));
    }

    static class SimpleArrayAdapter extends RecyclerView.Adapter<BindingHolder> {

        private final List<Person> persons;

        public SimpleArrayAdapter(List<Person> persons) {
            this.persons = persons;
        }

        @Override
        public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            final View view = inflater.inflate(R.layout.personlayout, parent, false);
            return new BindingHolder(view);
        }

        @Override
        public void onBindViewHolder(BindingHolder holder, int position) {


        }

        @Override
        public int getItemCount() {
            return persons.size();
        }
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {
        private PersonlayoutBinding personlayoutBinding;

        public BindingHolder(View rowView) {
            super(rowView);
            personlayoutBinding = DataBindingUtil.bind(rowView);
        }

        public PersonlayoutBinding getBinding() {
            return personlayoutBinding;
        }
    }
}
