package com.zakharchenko.oksana.gallery.dagger.components;


import com.zakharchenko.oksana.gallery.activities.StartActivity;
import com.zakharchenko.oksana.gallery.dagger.modules.StartModule;

import dagger.Subcomponent;

@Subcomponent(modules ={StartModule.class})
public interface StartComponent {

void inject(StartActivity activity);
}