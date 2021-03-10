package com.view.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.controller.main.GameControl;
import com.controller.viewcontrol.MainViewControl;
import com.model.player.Player;
import com.model.player.UserPlayer;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView extends JFrame {
	MainViewControl viewControl;;
	GameControl gameControl;;
	private JPanel contentPane;
	private JTextField textField_computerPlayerCount;
	private JList<Player> list_playerList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	/**
	 * Create the frame.
	 */
	public MainView() {
		/*
		 * init
		 */
		viewControl = new MainViewControl(800, 600);
		gameControl = new GameControl();
		Player master = new UserPlayer("master");
		gameControl.addUserPlayer(master);

		/*
		 * main panel
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, viewControl.getWidth(), viewControl.getHeight());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		/*
		 * west border: list
		 */
		list_playerList = new JList<>();
		list_playerList.setFont(new Font("新細明體", Font.PLAIN, 18));
		list_playerList.setModel(new AbstractListModel<Player>() {

			List<Player> players = gameControl.getPlayers();

			@Override
			public int getSize() {
				return players.size();
			}

			@Override
			public Player getElementAt(int index) {
				return players.get(index);
			}
		});
		contentPane.add(list_playerList, BorderLayout.WEST);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		textField_computerPlayerCount = new JTextField();
		panel.add(textField_computerPlayerCount);
		textField_computerPlayerCount.setColumns(10);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int count = 0;
				try {
					count = Integer.valueOf(textField_computerPlayerCount.getText());
				} catch (NumberFormatException ex) {
					count = 0;
				}
				gameControl.reCreateComputerPlayer(count);
				list_playerList.updateUI();
			}
		});
		btnNewButton.setToolTipText("add computer players");
		panel.add(btnNewButton);
	}

}
