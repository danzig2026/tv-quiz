package com.example.tvquizlock;

import android.accessibilityservice.AccessibilityService;

public class Access extends AccessibilityService {
    @Override
    public void onServiceConnected() {
        super.onServiceConnected();
    }
    @Override
    public void onAccessibilityEvent(android.view.accessibility.AccessibilityEvent event) {}
    @Override
    public void onInterrupt() {}
}