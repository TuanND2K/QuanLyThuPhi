/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.DongGopController;

import services.DongGopService;

/**
 *
 * @author TuanNguyen
 */
public class ThemDotDongGopController {
    private final DongGopService dongGopService = new DongGopService();

    public DongGopService getDongGopService() {
        return dongGopService;
    }
    
}
