import {
  Image,
  Pressable,
  ScrollView,
  StyleSheet,
  Text,
  View,
} from "react-native";
import React from "react";
import { SafeAreaView } from "react-native-safe-area-context";
import FormField from "@/components/ui/FormField";
import { router } from "expo-router";

import google from "@/assets/images/google.png";
import apple from "@/assets/images/apple.png";

const SignInPage = () => {
  return (
    <SafeAreaView>
      <ScrollView className="min-h-screen bg-white pt-6">
        <View className="text-center pt-8 px-6">
          <Text className=" font-semibold text-g60 text-center text-2xl">
            Sign In
          </Text>
          <Text className="text-base text-g50 pt-3 text-center">
            Stay connected, follow teams, and never miss thrilling Stay
            connected
          </Text>
        </View>
        <View className="pt-8 px-6 ">
          <FormField
            isTitle={true}
            placeholder="Enter email"
            title="Email"
            keyboardType="email-address"
          />
          <View className="pt-4">
            <FormField
              isTitle={true}
              placeholder=" Password"
              title="Password"
            />
          </View>
        </View>
        <Pressable
          onPress={() => router.push("/ForgotPassword" as any)}
          className="w-full items-end pt-2 pr-6"
        >
          <Text className=" font-bold text-g50">Forget password?</Text>
        </Pressable>

        <View className="px-4 pt-8">
          <Pressable
            onPress={() => router.push("/Home" as any)}
            className="w-full bg-g60 py-3 rounded-lg"
          >
            <Text className="text-center text-white text-base font-semibold">
              Sign In
            </Text>
          </Pressable>
        </View>

        <View className="pt-6 px-6">
          <View className="pb-12">
            <Text className="text-base text-bodyText text-center ">
              Don't have an account?{" "}
              <Text
                className=" text-p1 font-medium"
                onPress={() => router.push("/SignUpPage" as any)}
              >
                Sign Up
              </Text>{" "}
              here
            </Text>
          </View>
          <View className="border-t border-dashed border-g30 flex justify-center items-center dark:border-blackN50">
            <Text className="text-[14px] font-semibold text-center -mt-[10px] bg-white text-g60  w-fit px-2  ">
              Or Continue With
            </Text>
          </View>

          <View className="flex flex-col pt-8">
            <View className="flex-row justify-center items-center  p-4 rounded-full bg-g20 border border-g30 cursor-pointer">
              <Image source={google} />
              <Text className="text-sm font-semibold text-g60 pl-3">
                Continue with Google
              </Text>
            </View>
            <View className="mt-4 flex-row justify-center items-center  p-4 rounded-full bg-g20 border border-g30 cursor-pointer">
              <Image source={apple} />
              <Text className="text-sm font-semibold text-g60 pl-3">
                Continue with Apple
              </Text>
            </View>
          </View>
        </View>
      </ScrollView>
    </SafeAreaView>
  );
};

export default SignInPage;

const styles = StyleSheet.create({});
