package com.ediga.myquotemaker

import Data.SharedViewModel
import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

class MessageSenderFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
      return inflater.inflate(R.layout.fragment_send_message,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragmentManager = activity?.supportFragmentManager
        val messageReceiverFragment = MessageReceiverFragment()
        val transaction = fragmentManager?.beginTransaction()
        var sendMessageButton = view.findViewById<Button>(R.id.sendMessageButton)
        var sendMessageEditText = view.findViewById<EditText>(R.id.sendMessage)
        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        sendMessageButton.setOnClickListener(){
            model.sendMessage(sendMessageEditText.text.toString())
            findNavController().navigate(R.id.action_SecondFragment_to_MessageReceiverFragment)
        }
    }
}