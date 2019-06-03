package mx.cic.ipn.geo.servicio_monitoreo_memoria;

/**
 * Contiene las constantes de las acciones de los servicios y sus parámetros
 */
public class Constants {
    /**
     * Constantes para {@link MemoryService}
     */
    public static final String ACTION_RUN_SERVICE = "mx.cic.ipn.geo.servicio_monitoreo_memoria.RUN_SERVICE";
    public static final String ACTION_MEMORY_EXIT = "mx.cic.ipn.geo.servicio_monitoreo_memoria.MEMORY_EXIT";

    public static final String EXTRA_MEMORY = "mx.cic.ipn.geo.servicio_monitoreo_memoria.MEMORY";

    /**
     * Constantes para {@link ProgressIntentService}
     */
    public static final String ACTION_RUN_ISERVICE = "mx.cic.ipn.geo.servicio_monitoreo_memoria.RUN_INTENT_SERVICE";
    public static final String ACTION_PROGRESS_EXIT = "mx.cic.ipn.geo.servicio_monitoreo_memoria.PROGRESS_EXIT";

    public static final String EXTRA_PROGRESS = "mx.cic.ipn.geo.servicio_monitoreo_memoria.PROGRESS";
}
