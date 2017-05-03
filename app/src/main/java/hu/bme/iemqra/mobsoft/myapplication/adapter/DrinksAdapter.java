package hu.bme.iemqra.mobsoft.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import hu.bme.iemqra.mobsoft.myapplication.R;
import hu.bme.iemqra.mobsoft.myapplication.model.Drink;
import hu.bme.iemqra.mobsoft.myapplication.ui.drinkdetails.DrinkDetailsActivity;

// Az adapter mindig az inner class-ból fog származni, azért kell az aktuális osztály.ViewHolder megadás
public class DrinksAdapter extends RecyclerView.Adapter<DrinksAdapter.ViewHolder> {
    private Context context;

    //Az adapter tárolja a hozzá tartozó listát
    private List<Drink> drinkList;

    public DrinksAdapter(Context context, List<Drink> drinkList) {
        this.context = context;
        this.drinkList = drinkList;
    }

    //Megadjuk hogy az egyes view-k milyen layout szerint fognak felépülni, jelen esetben a layout-ban ismertetett kártyát fogjuk használni
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_drink, viewGroup, false);
        return new ViewHolder(itemView);
    }

    //Egy elem kötésekor fut, itt történik az aktuális elem meghatározása és a szövegek / képek beállítása
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Drink drink = drinkList.get(position);

        holder.tvId.setText(Long.toString(drink.getId()));
        holder.tvName.setText(drink.getName());
        holder.tvType.setText(drink.getType());
        holder.tvCount.setText(Integer.toString(drink.getCount()));
    }

    //A tárolt lista elemszámát adja vissza
    @Override
    public int getItemCount() {
        return drinkList.size();
    }

    //A kártyát magát jelképezi, a konstruktorában beállítjuk az egyes vezérlőket,
    // illetve feliratkozunk pl. a menü gomb OnClick eseményére is, hogy meg tudjuk jeleníteni a helyi menüt (showPopupMenu(...))
    // Az alábbi ViewHolder implementálja az OnClickListener interfészt is annak érdekében, hogy az adott kártyáról a részletes oldalra tudjunk navigálni.
    protected static class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        public TextView tvId;
        public TextView tvName;
        public TextView tvType;
        public TextView tvCount;

        //Mezők beállítása + eseményekre történő feliratkozás opcionálisan
        //A mezők beállítása kötelező, ezeket fogjuk majd elérni a fenti onBindViewHolder(...) függvényben
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
                    //TODO
                }
            });
        }

        //Navigáció kezelése
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), DrinkDetailsActivity.class);
            intent.putExtra("id", tvId.getText());
            v.getContext().startActivity(intent);
        }
    }
}