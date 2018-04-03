package com.example.user.bhak.data;

import android.provider.BaseColumns;

/**
 * Created by User on 4/8/2017.
 */

public class ProductContract {

    ProductContract(){}

    public static final class Product1Entry implements BaseColumns{

        public static final String TABLE_NAME="product_1";
        public static final String _ID=BaseColumns._ID;
        public static final String COLUMN_PRODUCT1_DESCRIPTION="description";
        public static final String COLUMN_PRODUCT1_COLOR="rang";
        public static final String COLUMN_PRODUCT1_PRICE="price";
        public static final String COLUMN_PRODUCT1_STOCK="stock";

    }

    public static final class Product2Entry implements BaseColumns{

        public static final String TABLE_NAME="product_2";
        public static final String _ID=BaseColumns._ID;
        public static final String COLUMN_PRODUCT2_DESCRIPTION ="description";
        public static final String COLUMN_PRODUCT2_COLOR ="rang";
        public static final String COLUMN_PRODUCT2_PRICE ="price";
        public static final String COLUMN_PRODUCT2_STOCK ="stock";

    }

    public static final class Product3Entry implements BaseColumns{

        public static final String TABLE_NAME="product_3";
        public static final String _ID=BaseColumns._ID;
        public static final String COLUMN_PRODUCT3_DESCRIPTION ="description";
        public static final String COLUMN_PRODUCT3_COLOR ="rang";
        public static final String COLUMN_PRODUCT3_PRICE ="price";
        public static final String COLUMN_PRODUCT3_STOCK ="stock";

    }


    public static final class Product4Entry implements BaseColumns{

        public static final String TABLE_NAME="product_4";
        public static final String _ID=BaseColumns._ID;
        public static final String COLUMN_PRODUCT4_DESCRIPTION ="description";
        public static final String COLUMN_PRODUCT4_COLOR ="rang";
        public static final String COLUMN_PRODUCT4_PRICE ="price";
        public static final String COLUMN_PRODUCT4_STOCK ="stock";

    }

    public static final class SignUpEntry implements BaseColumns{
        public static final String TABLE_NAME="sign_up";
        public static final String COLUMN_SIGNUP_NAME="name";
        public static final String COLUMN_SIGNUP_MAIL="mail";
        public static final String COLUMN_SIGNUP_ADDRESS="address";
        public static final String COLUMN_SIGNUP_PHONE="phone";
        public static final String COLUMN_SIGNUP_USERNAME="username";
        public static final String COLUMN_SIGNUP_PASSWORD="password";
    }

    public static final class CartEntry implements BaseColumns{

        public static final String TABLE_NAME="cart";
        public static final String _ID=BaseColumns._ID;
        public static final String COLUMN_CART_DESCRIPTION ="description";
        public static final String COLUMN_CART_COLOR ="rang";
        public static final String COLUMN_CART_PRICE ="price";
        public static final String COLUMN_CART_STOCK ="stock";

    }
}
