package com.example.receipttracking.model

import com.example.receipttracking.R


class DataRepository {

    /*
    *
    * In order to accomadate both mock receipts and newly entered receipts,
    * there is both a receiptImageResource INT  and a receiptImageURI: String
    *
    *
    *
    * receiptimageresource
    * imageURI
    *
    *
    * */

    companion object {

        var receiptList = mutableListOf<Receipts>()
        fun fillList() {

            receiptList.add(
                Receipts(
                    "Gavrielle Willeson",
                    "Automotive",
                    "Auer LLC",
                    284.5,
                    1559725103,
                    31337,
                    //^^^ this is mock id
                    R.drawable.receipt1,
                    "",
                    false

                )
            )


            receiptList.add(
                Receipts(
                    "Duff Lyddyard",
                    "Movies",
                    "Wintheiser-Von",
                    53.3,
                    1559594970,
                    31337,
                    R.drawable.receipt2,
                    "",
                    false
                )
            )


            receiptList.add(
                Receipts(
                    "Madelene Meldrum",
                    "Jewelery",
                    "Carter-Kohler",
                    49.94,
                    1549543289,
                    31337,
                    R.drawable.receipt3,
                    "",
                    true
                )
            )
            receiptList.add(
                Receipts(
                    "Fedora Dewsnap",
                    "Games",
                    "Mosciski LLC",
                    231.05,
                    1555447238,
                    31337,
                    R.drawable.receipt6,
                    "",
                    false
                )
            )

            receiptList.add(
                Receipts(
                    "Aland Streatfeild",
                    "Garden",
                    "Watsica and Sons",
                    27.06,
                    1554225573,
                    31337,
                    R.drawable.receipt4,
                    "",
                    false
                )
            )

            receiptList.add(

                Receipts(
                    "Giulia Cruces",
                    "Electronics",
                    "Wolf, Bartell and Daugherty",
                    23.89,
                    1556265103,
                    31337,
                    R.drawable.receipt5,
                    "",
                    false
                )
            )

            receiptList.add(
                Receipts(
                    "Gregorius Popworth",
                    "Grocery",
                    "Grady-Schaefer",
                    200.45,
                    1540639711,
                    31337,
                    R.drawable.receipt7,
                    "",
                    false
                )
            )

            receiptList.add(

                Receipts(
                    "Tabor Alenin",
                    "Home",
                    "Wuckert, Price and Funk",
                    51.62,
                    1558916915,
                    31337,
                    R.drawable.receipt8,
                    "",
                    false
                )
            )

            receiptList.add(

                Receipts(
                    "Carce Piris",
                    "Garden",
                    "McCullough-McKenzie",
                    217.82,
                    1540168811,
                    31337,
                    R.drawable.receipt9,
                    "",
                    false
                )
            )

            receiptList.add(

                Receipts(
                    "Gibbie Blackaller",
                    "Home",
                    "Hahn, Hauck and Langosh",
                    299.77,
                    1550174938,
                    31337,
                    R.drawable.receipt10,
                    "",
                    false
                )
            )

            receiptList.add(

                Receipts(
                    "Wadsworth Zeplin",
                    "Baby",
                    "Witting-Konopelski",
                    68.05,
                    1563718340,
                    31337,
                    R.drawable.receipt1,
                    "",
                    false
                )
            )

            receiptList.add(
                Receipts(
                    "Mabel Felten",
                    "Computers",
                    "Denesik Inc",
                    160.08,
                    1538492734,
                    31337,
                    R.drawable.receipt2,
                    "",
                    false
                )
            )

            receiptList.add(
                Receipts(
                    "Craig Atkin",
                    "Clothing",
                    "Carter, McCullough and Senger",
                    126.9,
                    1560000373,
                    31337,
                    R.drawable.receipt3,
                    "",
                    false
                )
            )

            receiptList.add(
                Receipts(
                    "Jaquelyn Medmore",
                    "Shoes",
                    "McLaughlin and Sons",
                    218.23,
                    1554597668,
                    31337,
                    R.drawable.receipt4,
                    "",
                    false
                )
            )

            receiptList.add(
                Receipts(
                    "Foster Pyecroft",
                    "Home",
                    "Green, Gusikowski and Funk",
                    245.54,
                    1557126126,
                    31337,
                    R.drawable.receipt5,
                    "",
                    false
                )
            )

            receiptList.add(
                Receipts(
                    "Darrin Cashin",
                    "Computers",
                    "Borer, Hartmann and Block",
                    23.2,
                    1546185817,
                    31337,
                    R.drawable.receipt7,
                    "",
                    false
                )
            )

            receiptList.add(
                Receipts(
                    "Burnaby Nunn",
                    "Shoes",
                    "Lesch LLC",
                    36.12,
                    1550961934,
                    31337,
                    R.drawable.receipt4,
                    "",
                    false
                )
            )
            receiptList.add(
                Receipts(
                    "Sande Husher",
                    "Outdoors",
                    "Witting, Kertzmann and Lockman",
                    5.68,
                    1542972260,
                    31337,
                    R.drawable.receipt8,
                    "",
                    false
                )
            )

            receiptList.add(
                Receipts(
                    "Celesta Greenroa",
                    "Kids",
                    "Lind-Gibson",
                    159.48,
                    1543160606,
                    31337,
                    R.drawable.receipt9,
                    "",
                    false
                )
            )

            receiptList.add(

                Receipts(
                    "Leda Abotson",
                    "Music",
                    "McKenzie, Langosh and D'Amore",
                    264.6,
                    1560995206,
                    31337,
                    R.drawable.receipt10,
                    "",
                    false
                )
            )
        }
    }
}