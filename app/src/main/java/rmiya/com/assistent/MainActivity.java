package rmiya.com.assistent;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bvapp.arcmenulibrary.ArcMenu;
import com.bvapp.arcmenulibrary.widget.FloatingActionButton;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

public class MainActivity extends AppCompatActivity {

    String arrayName[] = {
            "Facebook",
            "Twitter",
            "Youtube",
            "Windows",
            "Drive"
    };

    private CircleMenu circleMenu;

    private TextView text_alexa;

    private static final int[] ITEM_DRAWABLES = { R.drawable.facebook,
            R.drawable.twitter, R.drawable.flickr, R.drawable.instagram,
            R.drawable.skype, R.drawable.github };

    private static final String[] STR = {"Facebook","Twiiter","Flickr","Instagram","Skype","Github"};







//    version circle
//    private static final int[] ITEM_DRAWABLES = { R.drawable.facebook,
//            R.drawable.twitter, R.drawable.flickr, R.drawable.instagram,
//            R.drawable.skype, R.drawable.github };

//    private static final int[] menuId = {R.id.arcMenu,R.id.arcMenu2,R.id.arcMenu3,R.id.arcMenu4
//            ,R.id.arcMenu5,R.id.arcMenu6,R.id.arcMenu7,R.id.arcMenu8,R.id.arcMenu9};

//    private String[] str = {"Facebook","Twiiter","Flickr","Instagram","Skype","Github"};

//    private ArcMenu[] arcMenu = new ArcMenu[menuId.length];
//    private CoordinatorLayout coordinatorLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String fuente1 = "font/Anurati-Regular.otf";
        Typeface anutari = Typeface.createFromAsset(getAssets(), fuente1);

        text_alexa = (TextView) findViewById(R.id.ale);
        text_alexa.setTypeface(anutari);

        circleMenu = (CircleMenu) findViewById(R.id.circle_menu);

        circleMenu.setMainMenu(Color.parseColor("#00FFFFFF"), R.drawable.icon_menu, R.drawable.icon_cancel)
                .addSubMenu(Color.parseColor("#258CFF"), R.drawable.icon_home)
                .addSubMenu(Color.parseColor("#30A400"), R.drawable.icon_search)
                .addSubMenu(Color.parseColor("#FF4B32"), R.drawable.icon_notify)
                .addSubMenu(Color.parseColor("#8A39FF"), R.drawable.icon_setting)
                .addSubMenu(Color.parseColor("#FF6A00"), R.drawable.icon_gps)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {

                    @Override
                    public void onMenuSelected(int index) {}

                }).setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {

            @Override
            public void onMenuOpened() {}

            @Override
            public void onMenuClosed() {}

        });
//



        ArcMenu menu = (ArcMenu) findViewById(R.id.arcMenu);

        menu.showTooltip(true);
        menu.setToolTipBackColor(Color.WHITE);
        menu.setMinRadius(200);
        menu.setToolTipCorner(6f);
        menu.setToolTipPadding(2f);
        menu.setToolTipTextColor(Color.BLUE);
        menu.setAnim(300,300,ArcMenu.ANIM_MIDDLE_TO_RIGHT,ArcMenu.ANIM_MIDDLE_TO_RIGHT,
                ArcMenu.ANIM_INTERPOLATOR_ACCELERATE_DECLERATE,ArcMenu.ANIM_INTERPOLATOR_ACCELERATE_DECLERATE);

        final int itemCount = ITEM_DRAWABLES.length;
        for (int i = 0; i < itemCount; i++) {
            FloatingActionButton item = new FloatingActionButton(this);  // Use internal FAB as child
            // ********* import com.bvapp.arcmenulibrary.widget.FloatingActionButton; *********

            item.setSize(FloatingActionButton.SIZE_MINI); // set initial size for child, it will create fab first
            item.setIcon(ITEM_DRAWABLES[i]); // It will set fab icon from your resources which related to 'ITEM_DRAWABLES'
            item.setBackgroundColor(getResources().getColor(R.color.colorPrimary)); // it will set fab child's color
            menu.setChildSize(item.getIntrinsicHeight()); // set absolout child size for menu

            final int position = i;
            menu.addItem(item, STR[i], new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //You can access child click in here
                }
            });
        }








//        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.layMain);
//
//        for(int i=0; i<arcMenu.length; i++){
//            arcMenu[i] = (ArcMenu) findViewById(menuId[i]);
//            initArcMenu(arcMenu[i], str, ITEM_DRAWABLES, i);
//        }

    }

//    @Override
//    public boolean onMenuOpened(int featureId, Menu menu) {
//        circleMenu.openMenu();
//        return super.onMenuOpened(featureId, menu);
//    }
//
//    @Override
//    public void onBackPressed() {circleMenu.closeMenu();
//    }

//    private void initArcMenu(final ArcMenu menu, final String[] str, int[] itemDrawables, final int menuNum) {
//        final int itemCount = itemDrawables.length;
//        for (int i = 0; i < itemCount; i++) {
//            ImageView item = new ImageView(this);
//            item.setImageResource(itemDrawables[i]);
//
//            if(menuNum == 1){
//                menu.setAnim(400,400, ArcMenu.ANIM_MIDDLE_TO_DOWN, ArcMenu.ANIM_MIDDLE_TO_RIGHT,
//                        ArcMenu.ANIM_INTERPOLATOR_DECLERATE, ArcMenu.ANIM_INTERPOLATOR_BOUNCE);
//            }
//
//            if(menuNum == 4){
//                menu.setAnim(500,500, ArcMenu.ANIM_MIDDLE_TO_DOWN, ArcMenu.ANIM_MIDDLE_TO_RIGHT,
//                        ArcMenu.ANIM_INTERPOLATOR_ANTICIPATE, ArcMenu.ANIM_INTERPOLATOR_ANTICIPATE);
//            }
//
//            final int position = i;
//            menu.addItem(item, str[i], new View.OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(MainActivity.this,  str[position],
//                            Toast.LENGTH_SHORT).show();
//                    Snackbar snackbar = Snackbar
//                            .make(coordinatorLayout, "Hello this is " + str[position], Snackbar.LENGTH_LONG);
//                    snackbar.show();
//                }
//            });
//        }
//    }
//
}
