package website.eccentric.tome.services;

import java.util.List;
import java.util.Map;

public class ConfigurationImpl implements Configuration {

    private static boolean allItems = false;
    private static boolean disableOverlay = false;

    private static List<? extends String> items = List.of(
        "tconstruct:materials_and_you",
        "tconstruct:puny_smelting",
        "tconstruct:mighty_smelting",
        "tconstruct:fantastic_foundry",
        "tconstruct:tinkers_gadgetry",
        "integrateddynamics:on_the_dynamics_of_integration",
        "cookingforblockheads:no_filter_edition",
        "alexsmobs:animal_dictionary",
        "occultism:dictionary_of_spirits",
        "theoneprobe:probenote",
        "compactmachines:personal_shrinking_device"
    );

    private static List<? extends String> names = List.of(
        "book",
        "tome",
        "lexicon",
        "nomicon",
        "manual",
        "knowledge",
        "pedia",
        "compendium",
        "guide",
        "codex",
        "journal",
        "enchiridion"
    );

    private static Map<String, String> aliases = Map.of(
        "thermalexpansion", "thermalfoundation",
        "thermaldynamics", "thermalfoundation",
        "thermalcultivation", "thermalfoundation",
        "redstonearsenal", "thermalfoundation",
        "rftoolsdim", "rftools",
        "rftoolspower", "rftools",
        "rftoolscontrol", "rftools",
        "xnet", "rftools"
    );

    private static List<? extends String> exclude = List.of();
    
    private static List<? extends String> excludeItems = List.of(
        "apotheosis:boots_tome",
        "apotheosis:bow_tome",
        "apotheosis:chestplate_tome",
        "apotheosis:fishing_tome",
        "apotheosis:helmet_tome",
        "apotheosis:leggings_tome",
        "apotheosis:other_tome",
        "apotheosis:pickaxe_tome",
        "apotheosis:scrap_tome",
        "apotheosis:weapon_tome",
        "ars_nouveau:annotated_codex",
        "darkutils:tome_enchanting",
        "darkutils:tome_illager",
        "darkutils:tome_pigpen",
        "darkutils:tome_runelic",
        "darkutils:tome_sga",
        "darkutils:tome_shadows",
        "minecolonies:ancienttome",
        "occultism:book_of_binding_afrit",
        "occultism:book_of_binding_bound_afrit",
        "occultism:book_of_binding_bound_djinni",
        "occultism:book_of_binding_bound_foliot",
        "occultism:book_of_binding_bound_marid",
        "occultism:book_of_binding_djinni",
        "occultism:book_of_binding_foliot",
        "occultism:book_of_binding_marid",
        "occultism:book_of_calling_djinni_manage_machine",
        "occultism:book_of_calling_foliot_cleaner",
        "occultism:book_of_calling_foliot_lumberjack",
        "occultism:book_of_calling_foliot_transport_items",
        "tombstone:book_of_disenchantment",
        "tombstone:book_of_recycling",
        "tombstone:book_of_repairing",
        "tombstone:book_of_magic_impregnation"
    );
        
    public boolean allItems() {
        return allItems;
    }

    public boolean disableOverlay() {
        return disableOverlay;
    }

    public List<? extends String> items() {
        return items;
    }

    public List<? extends String> names() {
        return names;
    }

    public Map<String, String> aliases() {
        return aliases;
    }

    public List<? extends String> exclude() {
        return exclude;
    }

    public List<? extends String> excludeItems() {
        return excludeItems;
    }
    

    public void refresh() {
        // TODO: write this
    }
}
