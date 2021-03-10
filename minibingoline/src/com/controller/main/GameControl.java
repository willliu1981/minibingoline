package com.controller.main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.model.player.ComputerPlayer;
import com.model.player.Player;
import com.model.player.UserPlayer;

public class GameControl {

	private List<Player> players;

	public GameControl() {
		players = new ArrayList<>();
	}

	public void addUserPlayer(Player player) {
		this.players.add(player);
	}

	public Player getPlayer(int index) {
		return this.players.get(index);
	}

	public Player getPlayer(String name) {
		Player player = this.players.stream().filter(x -> {
			return x.getName().equals(name);
		}).findFirst().get();
		return player;
	}

	public List<Player> getPlayers() {
		return this.players;
	}

	public void removeComputerPlayer() {
		this.players = this.players.stream().filter(x -> {
			return x instanceof UserPlayer;
		}).collect(Collectors.toList());
	}

	public void reCreateComputerPlayer(int count) {
		this.removeComputerPlayer();
		for (int i = 0; i < count; i++) {
			String name = "Com " + i;
			this.players.add(new ComputerPlayer(name));
		}
	}

}
