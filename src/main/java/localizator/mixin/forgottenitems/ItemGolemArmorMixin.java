package localizator.mixin.forgottenitems;

import localizator.data.Production;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tschipp.forgottenitems.items.ItemGolemArmor;

import java.util.List;

@Mixin(ItemGolemArmor.class)
public abstract class ItemGolemArmorMixin {
    /**
     * @author KameiB
     * @reason Localize item description
     */
    @Inject(
            method = "addInformation(Lnet/minecraft/item/ItemStack;Lnet/minecraft/world/World;Ljava/util/List;Lnet/minecraft/client/util/ITooltipFlag;)V",
            at = @At("HEAD"),
            cancellable = true,
            remap = Production.inProduction
    )
    @SideOnly(Side.CLIENT)
    // Line 61
    private void ForgottenItems_ItemGolemArmor_addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag, CallbackInfo ci)
    {        
        tooltip.add(I18n.format(((Item)((Object)this)).getUnlocalizedNameInefficiently(stack) + ".desc"));
        ci.cancel();
    }
}
