package com.pinkulu.heightlimitmod.command;

import cc.polyfrost.oneconfig.utils.commands.annotations.SubCommand;
import com.pinkulu.heightlimitmod.HeightLimitMod;
import cc.polyfrost.oneconfig.utils.commands.annotations.Command;
import cc.polyfrost.oneconfig.utils.commands.annotations.Main;
import com.pinkulu.heightlimitmod.util.APICaller;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.fml.common.API;

@Command(value = HeightLimitMod.MODID,
        description = "Access the " + HeightLimitMod.NAME + " GUI.", aliases = {"hlm", "heightlimitmod"})
public class HeightLimitModCommand {

    @Main
    private static void main() {
        HeightLimitMod.INSTANCE.config.openGui();
    }
    @SubCommand(aliases = "update", description = "check if theres an update")
    public static class update {
            EntityPlayer player = Minecraft.getMinecraft().thePlayer;
            IChatComponent text = new ChatComponentText( "Api version:" + APICaller.latest_version);
            player.addChatMessage(text);
    }
    @SubCommand(aliases = "refreshlimits", description = "Pulls the height limit maps api, pulling the latest limits")
    private static class refreshLimits{
            APICaller.GetVersion();
            EntityPlayer player = Minecraft.getMinecraft().thePlayer;
            IChatComponent text = new ChatComponentText( "The limits have been refreshed!");
            player.addChatMessage(text);
        }
    }
