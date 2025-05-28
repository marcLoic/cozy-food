/* eslint-disable */
import * as Router from 'expo-router';

export * from 'expo-router';

declare module 'expo-router' {
  export namespace ExpoRouter {
    export interface __routes<T extends string = string> extends Record<string, unknown> {
      StaticRoutes: `/` | `/(account-pages)` | `/(account-pages)/AccountSecurity` | `/(account-pages)/AddNewAddress` | `/(account-pages)/AddNewPaymentMethod` | `/(account-pages)/AddressDetails` | `/(account-pages)/AppApearance` | `/(account-pages)/ChooseAddress` | `/(account-pages)/ChooseDelivery` | `/(account-pages)/DataAnalytics` | `/(account-pages)/HelpCenter` | `/(account-pages)/HelpSupport` | `/(account-pages)/Language` | `/(account-pages)/ManageAddress` | `/(account-pages)/MyProfile` | `/(account-pages)/NotificationSetting` | `/(account-pages)/PaymentMethods` | `/(account-pages)/PrivacyPolicy` | `/(account-pages)/PromosVouchers` | `/(account-pages)/TermsService` | `/(auth-pages)` | `/(auth-pages)/ForgotPassword` | `/(auth-pages)/ResetSuccessfully` | `/(auth-pages)/SignInPage` | `/(auth-pages)/SignUpPage` | `/(auth-pages)/VerifyOTP` | `/(screens)` | `/(screens)/AllProducts` | `/(screens)/AvailableVouchers` | `/(screens)/CameraViewPage` | `/(screens)/CancelSuccessfully` | `/(screens)/Checkout` | `/(screens)/LeaveReview` | `/(screens)/OnBoardingSlider` | `/(screens)/OrderDetails` | `/(screens)/PlaceOrderSuccessfully` | `/(screens)/ProductDetails` | `/(screens)/RatingReviews` | `/(screens)/ReviewPostedSuccessfully` | `/(screens)/Search` | `/(screens)/TrackOrder` | `/(tabs)` | `/(tabs)/Cart` | `/(tabs)/Home` | `/(tabs)/MyOrder` | `/(tabs)/Profile` | `/(tabs)/WishList` | `/AccountSecurity` | `/AddNewAddress` | `/AddNewPaymentMethod` | `/AddressDetails` | `/AllProducts` | `/AppApearance` | `/AvailableVouchers` | `/CameraViewPage` | `/CancelSuccessfully` | `/Cart` | `/Checkout` | `/ChooseAddress` | `/ChooseDelivery` | `/DataAnalytics` | `/ForgotPassword` | `/HelpCenter` | `/HelpSupport` | `/Home` | `/Language` | `/LeaveReview` | `/ManageAddress` | `/MyOrder` | `/MyProfile` | `/NotificationSetting` | `/OnBoardingSlider` | `/OrderDetails` | `/PaymentMethods` | `/PlaceOrderSuccessfully` | `/PrivacyPolicy` | `/ProductDetails` | `/Profile` | `/PromosVouchers` | `/RatingReviews` | `/ResetSuccessfully` | `/ReviewPostedSuccessfully` | `/Search` | `/SignInPage` | `/SignUpPage` | `/TermsService` | `/TrackOrder` | `/VerifyOTP` | `/WishList` | `/_sitemap`;
      DynamicRoutes: never;
      DynamicRouteTemplate: never;
    }
  }
}
