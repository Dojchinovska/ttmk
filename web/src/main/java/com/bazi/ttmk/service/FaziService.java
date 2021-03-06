package com.bazi.ttmk.service;

import com.bazi.ttmk.model.Faza;
import com.bazi.ttmk.model.dto.IgrachiInTurnirMech;

import java.util.List;

public interface FaziService {

    List<Faza> getAllFazi();

    Faza createFaza(int idTurnir, int idKategorija, String opisFaza, int brojFaza);

}
