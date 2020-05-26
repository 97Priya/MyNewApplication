package application.example.mynewapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import application.example.mynewapplication.R;
import application.example.mynewapplication.models.Contact;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ContactViewHolder> {
    private ArrayList<Contact> mContacts;

    public RecyclerViewAdapter(ArrayList<Contact> contacts) {
        mContacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        // Inflate the layout
        View contactView = inflater.inflate(R.layout.contact_view, parent, false);
        ContactViewHolder viewHolder = new ContactViewHolder(contactView);
        return viewHolder;
        // return new ContactViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.name.setText(mContacts.get(position).getName());
        holder.phoneNo.setText(mContacts.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    protected class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView phoneNo;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.contact_name);
            phoneNo = itemView.findViewById(R.id.contact_number);

        }
    }

}
