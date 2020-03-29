package com.mijaz.hangman.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_item.view.*

import com.mijaz.hangman.R
import kotlinx.android.synthetic.main.fragment_config.*

/**
 * A simple [Fragment] subclass.
 */
class ConfigFragment : Fragment() {

    private lateinit var diffRecycler: RecyclerView
    private lateinit var viewModel: ConfigViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_config, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ConfigViewModel::class.java)
        diffRecycler = view.findViewById(R.id.diff_recycler)
        diffRecycler.layoutManager = LinearLayoutManager(context)
        diffRecycler.adapter = diffAdapter(viewModel.difficulty)
        game_button.setOnClickListener {
            view.findNavController().navigate(R.id.ConfigToGame)
        }
    }

    private inner class diffViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        private val numberTextView: TextView = itemView.diffNumber
        private val titleTextView: TextView = itemView.diffTitle

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

            //Toast.makeText(activity,viewModel.diff[adapterPosition], Toast.LENGTH_LONG).show()
        }

        fun bind(difficulty: String) {
            numberTextView.text = (adapterPosition + 1).toString()
            titleTextView.text = difficulty
        }
    }

    private inner class diffAdapter(private val difficulty: List<String>) :
        RecyclerView.Adapter<diffViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): diffViewHolder {
            val view = layoutInflater.inflate(R.layout.card_item, parent, false)
            return diffViewHolder(view)
        }

        override fun getItemCount() = difficulty.size

        override fun onBindViewHolder(holder: diffViewHolder, position: Int) {
            holder.bind(difficulty[position])
        }
    }

}
