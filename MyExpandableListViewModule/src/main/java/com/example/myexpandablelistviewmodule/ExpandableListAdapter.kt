package com.example.myexpandablelistviewmodule

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.TextView
import android.widget.Toast

class ExpandableListAdapter(var context: Context, var expandableListView : ExpandableListView, var header : MutableList<String>, var body : MutableList<MutableList<String>>) : BaseExpandableListAdapter(){
    //Gets the data associated with the given group.
    override fun getGroup(groupPosition: Int): String {
        return header[groupPosition]
    }

    //Whether the child at the specified position is selectable.
    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    //Indicates whether the child and group IDs are stable across changes to the underlying data.
    override fun hasStableIds(): Boolean {
        return false
    }

    //Gets a View that displays the given group.
    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        if (convertView == null){
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.layout_group,null)
        }
        val title = convertView?.findViewById<TextView>(R.id.tv_title)
        title?.text = getGroup(groupPosition)
        title?.setOnClickListener{
            if (expandableListView.isGroupExpanded(groupPosition))
                expandableListView.collapseGroup(groupPosition)
            else
                expandableListView.expandGroup(groupPosition)
            Toast.makeText(context, getGroup(groupPosition),Toast.LENGTH_SHORT).show()
        }
        return convertView
    }

    //Gets the number of children in a specified group.
    override fun getChildrenCount(groupPosition: Int): Int {
        return body[groupPosition].size
    }

    //Gets the data associated with the given child within the given group.
    override fun getChild(groupPosition: Int, childPosition: Int): String {
        return body[groupPosition][childPosition]
    }

    //Gets the ID for the group at the given position.
    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    //Gets a View that displays the data for the given child within the given group.
    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        var convertView = convertView
        if (convertView == null){
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.layout_child,null)
        }
        val title = convertView?.findViewById<TextView>(R.id.tv_title)
        title?.text = getChild(groupPosition,childPosition)
        title?.setOnClickListener{
            Toast.makeText(context, getChild(groupPosition,childPosition),Toast.LENGTH_SHORT).show()
        }
        return convertView
    }

    //Gets the ID for the given child within the given group. This ID must be unique across all children within the group.
    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    //Gets the number of groups.
    override fun getGroupCount(): Int {
        return header.size
    }

}