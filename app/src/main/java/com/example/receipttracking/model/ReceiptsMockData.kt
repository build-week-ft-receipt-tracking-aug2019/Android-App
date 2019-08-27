package com.example.receipttracking.model


class ReceiptsMockData() {
    companion object {
        var receipt_list = mutableListOf<Receipts>()
        fun fillList() {
            //fullname,category,merchantname,cost,date,mockid,receiptimageresource
            receipt_list.add(
                Receipts(
                    "Gavrielle Willeson",
                    "Automotive",
                    "Auer LLC",
                    284.5,
                    1559725103,
                    1,
                    1
                )
            )

            receipt_list.add(
                Receipts(
                    "Duff Lyddyard",
                    "Movies",
                    "Wintheiser-Von",
                    53.3,
                    1559594970,
                    2,
                    2
                )
            )

            receipt_list.add(
                Receipts(
                    "Madelene Meldrum",
                    "Jewelery",
                    "Carter-Kohler",
                    49.94,
                    1549543289,
                    3,
                    3
                )
            )
            receipt_list.add(Receipts("Fedora Dewsnap", "Games", "Mosciski LLC", 231.05, 1555447238, 4, 4))
            receipt_list.add(
                Receipts(
                    "Aland Streatfeild",
                    "Garden",
                    "Watsica and Sons",
                    27.06,
                    1554225573,
                    5,
                    5
                )
            )
            receipt_list.add(
                Receipts(
                    "Giulia Cruces",
                    "Electronics",
                    "Wolf, Bartell and Daugherty",
                    23.89,
                    1556265103,
                    6,
                    6
                )
            )
            receipt_list.add(
                Receipts(
                    "Gregorius Popworth",
                    "Grocery",
                    "Grady-Schaefer",
                    200.45,
                    1540639711,
                    7,
                    7
                )
            )
            receipt_list.add(
                Receipts(
                    "Tabor Alenin",
                    "Home",
                    "Wuckert, Price and Funk",
                    51.62,
                    1558916915,
                    8,
                    8
                )
            )
            receipt_list.add(
                Receipts(
                    "Carce Piris",
                    "Garden",
                    "McCullough-McKenzie",
                    217.82,
                    1540168811,
                    9,
                    9
                )
            )

            receipt_list.add(
                Receipts(
                    "Gibbie Blackaller",
                    "Home",
                    "Hahn, Hauck and Langosh",
                    299.77,
                    1550174938,
                    10,
                    10
                )
            )
            receipt_list.add(
                Receipts(
                    "Wadsworth Zeplin",
                    "Baby",
                    "Witting-Konopelski",
                    68.05,
                    1563718340,
                    11,
                    11
                )
            )
            receipt_list.add(
                Receipts(
                    "Mabel Felten",
                    "Computers",
                    "Denesik Inc",
                    160.08,
                    1538492734,
                    12,
                    12
                )
            )
            receipt_list.add(
                Receipts(
                    "Craig Atkin",
                    "Clothing",
                    "Carter, McCullough and Senger",
                    126.9,
                    1560000373,
                    13,
                    13
                )
            )
            receipt_list.add(
                Receipts(
                    "Jaquelyn Medmore",
                    "Shoes",
                    "McLaughlin and Sons",
                    218.23,
                    1554597668,
                    14,
                    14
                )
            )
            receipt_list.add(
                Receipts(
                    "Foster Pyecroft",
                    "Home",
                    "Green, Gusikowski and Funk",
                    245.54,
                    1557126126,
                    15,
                    15
                )
            )
            receipt_list.add(
                Receipts(
                    "Darrin Cashin",
                    "Computers",
                    "Borer, Hartmann and Block",
                    23.2,
                    1546185817,
                    16,
                    16
                )
            )
            receipt_list.add(Receipts("Burnaby Nunn", "Shoes", "Lesch LLC", 36.12, 1550961934, 17, 17))
            receipt_list.add(
                Receipts(
                    "Sande Husher",
                    "Outdoors",
                    "Witting, Kertzmann and Lockman",
                    5.68,
                    1542972260,
                    18,
                    18
                )
            )
            receipt_list.add(
                Receipts(
                    "Celesta Greenroa",
                    "Kids",
                    "Lind-Gibson",
                    159.48,
                    1543160606,
                    19,
                    19
                )
            )
            receipt_list.add(
                Receipts(
                    "Leda Abotson",
                    "Music",
                    "McKenzie, Langosh and D'Amore",
                    264.6,
                    1560995206,
                    20,
                    20
                )
            )
        }
    }
}