# Secret Gallery

A secure Android app for hiding and protecting private photos and videos behind a password.

## Features

- Password protection with numeric PIN
- Security question for password recovery
- Hide photos and videos from device gallery
- Support for multiple file selections
- Dark theme support
- In-app purchase integration with Bazaar market
- Secure storage of media files

## Requirements

- Android 4.4+ (API 19+)
- Storage permissions for accessing media files
- Internet permission for in-app purchases
- Bazaar market app installed for payments

## Security

The app implements several security measures:

- Files are stored in the app's private storage
- PIN must be 4+ digits
- Security question required during setup
- Original files are deleted from gallery after import
- Files can only be accessed through the app interface

## Libraries Used

- Glide - Image loading and caching
- Volley - Network requests
- BlurKit - UI blur effects
- Android Room - Local database

## Build & Installation

1. Clone the repository
2. Open in Android Studio
3. Configure your signing key
4. Build and run on device
