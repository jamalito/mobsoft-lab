package hu.bme.iemqra.mobsoft.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import hu.bme.iemqra.mobsoft.myapplication.R;
import hu.bme.iemqra.mobsoft.myapplication.model.Drink;
import hu.bme.iemqra.mobsoft.myapplication.ui.drinkdetails.DrinkDetailsActivity;

public class DrinksAdapter extends RecyclerView.Adapter<DrinksAdapter.ViewHolder> {
    private Context context;

    private List<Drink> drinkList;

    public DrinksAdapter(Context context, List<Drink> drinkList) {
        this.context = context;
        this.drinkList = drinkList;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_drink, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Drink drink = drinkList.get(position);

        holder.tvId.setText(Long.toString(drink.getId()));
        holder.tvName.setText(drink.getName());
        holder.tvType.setText(drink.getType());
        holder.tvCount.setText(Integer.toString(drink.getCount()));
    }

    @Override
    public int getItemCount() {
        return drinkList.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        public TextView tvId;
        public TextView tvName;
        public TextView tvType;
        public TextView tvCount;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            tvId = (TextView) itemView.findViewById(R.id.cardDrink_tvId);
            tvName = (TextView) itemView.findViewById(R.id.cardDrink_tvName);
            tvType = (TextView) itemView.findViewById(R.id.cardDrink_tvType);
            tvCount = (TextView) itemView.findViewById(R.id.cardDrink_tvCount);

            ImageButton contextMenu = (ImageButton) itemView.findViewById(R.id.cardDrink_favouriteButton);
            contextMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), DrinkDetailsActivity.class);
            intent.putExtra("id", tvId.getText());
            intent.putExtra("name", tvName.getText());
            intent.putExtra("type", tvType.getText());
            intent.putExtra("count", Integer.parseInt(tvCount.getText().toString()));
            v.getContext().startActivity(intent);
        }
    }
}