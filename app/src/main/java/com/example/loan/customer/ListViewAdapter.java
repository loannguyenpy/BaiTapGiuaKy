package com.example.loan.customer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by LOAN on 8/1/2016.
 */
public class ListViewAdapter extends BaseAdapter
{
    private Context mContext;
    private List<Customer> customerList;
    public ListViewAdapter(Context context, List<Customer> customerList) {
        super();
        this.mContext=context;
        this.customerList=customerList;
    }

    @Override
    public int getCount() {
        return customerList.size();
    }

    @Override
    public Object getItem(int position) {
        return customerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view;
        final ListViewHolder listViewHolder;
        if(convertView==null)
        {
           view= LayoutInflater.from(mContext).inflate(R.layout.listview_item_customer,parent,false);
            listViewHolder=new ListViewHolder(mContext,view);
            view.setTag(listViewHolder);

        }
        else
        {
            view=convertView;
            listViewHolder=(ListViewHolder)view.getTag();
        }
        if(listViewHolder!=null)
        {
            listViewHolder.setData(customerList.get(position));
        }
        return view;
    }
    private class ListViewHolder
    {
        TextView mTextViewName;
        TextView mTextViewNoteBook;
        TextView mTextViewBook;
        TextView mTextViewPen;
        TextView mTextViewSum;
        public ListViewHolder(Context context, View view)
        {
          mTextViewName=(TextView)view.findViewById(R.id.textViewName);
          mTextViewNoteBook=(TextView)view.findViewById(R.id.textViewNoteBook);
          mTextViewBook=(TextView)view.findViewById(R.id.textViewBook);
          mTextViewPen=(TextView)view.findViewById(R.id.textViewPen);
          mTextViewSum=(TextView)view.findViewById(R.id.textViewSum);
        }
        public void setData(Customer customer)
        {
            mTextViewName.setText(customer.getName());
            mTextViewNoteBook.setText(customer.getNoteBook());
            mTextViewBook.setText(customer.getBook());
            mTextViewPen.setText(customer.getPen());
            mTextViewSum.setText(customer.sum()+" VNĐ");
        }
    }
}
