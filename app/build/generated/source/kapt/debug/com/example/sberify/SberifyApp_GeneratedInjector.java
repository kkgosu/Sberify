package com.example.sberify;

import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = SberifyApp.class
)
@GeneratedEntryPoint
@InstallIn(SingletonComponent.class)
public interface SberifyApp_GeneratedInjector {
  void injectSberifyApp(SberifyApp sberifyApp);
}
