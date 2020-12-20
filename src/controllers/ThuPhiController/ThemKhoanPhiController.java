/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.ThuPhiController;

import services.ThuPhiService;

/**
 *
 * @author TuanNguyen
 */
public class ThemKhoanPhiController {
    private final ThuPhiService thuPhiService = new ThuPhiService();

    public ThuPhiService getThuPhiService() {
        return thuPhiService;
    }
    
}
