package com.example.receipttracking.model


class ReceiptsMockData() {
    companion object {
        var receiptList = mutableListOf<Receipts>()
        fun fillList() {
            //fullname,category,merchantname,cost,date,mockid,receiptimageresource
            receiptList.add(
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

            receiptList.add(
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

            receiptList.add(
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
            receiptList.add(Receipts("Fedora Dewsnap", "Games", "Mosciski LLC", 231.05, 1555447238, 4, 4))
            receiptList.add(
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
            receiptList.add(
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
            receiptList.add(
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
            receiptList.add(
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
            receiptList.add(
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

            receiptList.add(
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
            receiptList.add(
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
            receiptList.add(
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
            receiptList.add(
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
            receiptList.add(
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
            receiptList.add(
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
            receiptList.add(
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
            receiptList.add(Receipts("Burnaby Nunn", "Shoes", "Lesch LLC", 36.12, 1550961934, 17, 17))
            receiptList.add(
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
            receiptList.add(
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
            receiptList.add(
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