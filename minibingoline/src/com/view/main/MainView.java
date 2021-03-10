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
import javax.swing.DefaultListModel;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class MainView extends JFrame {
	private static String CardLayout_topbar_set = "cardlayout_topbar_set";
	private static String CardLayout_topbar_start = "cardlayout_topbar_start";

	MainViewControl viewControl;;
	GameControl gameControl;
	private JPanel contentPane;
	private JList<Player> list_playerList;
	private JPanel panel_set;
	private JTextField textField_addComputerPlayerCount;
	private JButton btnNewButton;
	private JPanel panel_start;
	private JPanel panel_topbar;
	private JButton btnNewButton_1;

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
		 * north border:topbar
		 */
		panel_topbar = new JPanel();
		contentPane.add(panel_topbar, BorderLayout.NORTH);
		panel_topbar.setLayout(new CardLayout(0, 0));

		panel_set = new JPanel();
		panel_topbar.add(panel_set, CardLayout_topbar_set);

		textField_addComputerPlayerCount = new JTextField();
		textField_addComputerPlayerCount.setColumns(10);
		panel_set.add(textField_addComputerPlayerCount);

		btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int count=0;
				try {
					count =Integer.valueOf(textField_addComputerPlayerCount.getText());
				}catch(NumberFormatException ex) {
					count=0;
				}
				DefaultListModel<Player> model = new DefaultListModel<>();
				gameControl.reCreateComputerPlayer(count);
				gameControl.getPlayers().stream().forEach(x -> {
					model.addElement(x);
				});
				list_playerList.setModel(model);
				((CardLayout) panel_topbar.getLayout()).show(panel_topbar, CardLayout_topbar_start);
			}
		});
		btnNewButton.setToolTipText("add computer players");
		panel_set.add(btnNewButton);
		panel_start = new JPanel();
		panel_topbar.add(panel_start, CardLayout_topbar_start);

		btnNewButton_1 = new JButton("Start");
		btnNewButton_1.setToolTipText("start game");
		panel_start.add(btnNewButton_1);

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

	}

}
