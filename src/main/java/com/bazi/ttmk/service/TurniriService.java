package com.bazi.ttmk.service;

import com.bazi.ttmk.model.Turnir;

import java.util.Date;
import java.util.List;

public interface TurniriService {

    List<Turnir> getAllTurniri();

    Turnir createTurnir(int idSezona, int idKategorija, String ime, Date data, int participacija, int idSala, int brIgrachi);
}
