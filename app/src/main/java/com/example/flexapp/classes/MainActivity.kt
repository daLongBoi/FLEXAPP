package com.example.flexapp.classes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.flexapp.R
import kotlinx.android.synthetic.main.ticket.view.*

class MainActivity : AppCompatActivity() {
    var listFoods=ArrayList<foodview>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        //seed data for foods view
        listFoods.add(foodview(1, "food", "cllories 3000 , size 500 grams  "))
        listFoods.add(foodview(2, "food", "cllories 3000 , size 500 grams  "))
        listFoods.add(foodview(3, "food", "cllories 3000 , size 500 grams  "))

    }
        inner class myfoodsAdapter:BaseAdapter{
            var listFoodsAdapter=ArrayList<foodview>()
            constructor(listFoodsAdapter:ArrayList<foodview>):super(){
                this.listFoodsAdapter=listFoodsAdapter
        }

            override fun getCount(): Int {
             return listFoodsAdapter.size
            }

            override fun getItem(position: Int): Any {
              return listFoodsAdapter[position]
            }

            override fun getItemId(position: Int): Long {
                TODO("Not yet implemented")
            }

          /*  override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
               var myView=layoutInflater.inflate(R.layout.ticket,null)
                var myNode = listFoodsAdapter[position]
                myView.titleTextView.text=myNode.nodeName
                myView.descriptionTextView.text=myNode.nodeDes
            }*/

            override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

                var myView=layoutInflater.inflate(R.layout.ticket,null)

                var myNote=listFoodsAdapter[p0]
                myView.titleTextView.text=myNote.nodeName
                myView.descriptionTextView.text=myNote.nodeDes
                myView.ivDelete.setOnClickListener{
                    var dbManager=DbManager(this.context!!)
                    val selectionArgs= arrayOf(myNote.nodeID.toString())
                    dbManager.Delete("ID=?",selectionArgs)
                    LoadQuery("%")
                }
                myView.ivEdit.setOnClickListener{

                    GoToUpdate(myNote)

                }
                return myView
            }
        }
        /********************** User Methods ********************************/

        /*user methods*/
        //add user method

        //a method that allows the system to add a user and save changes to the db


        //edit user method
        //a method that allows the system to edit a user and save the changes to the db

        //view user details
        //a method that returns a view of the users details

        /**********************Pt user**********************************/

        //view user

        //view user list
        //a method that returns a table with all the user names with an integrated search

        //delete user


        /********************** Foods  ********************************/


        //add food

        //edit food (admin)

        //delete food

        //scan food image

        //scan food barcode

        //food list


        //food search



        /********************** Exercises ********************************/

        //add exercise

        //edit exercise (admin)

        //delete Exercise


        //Exercise list

        //Exercise search

        /******************** Chat system methods ***********************/








    }
