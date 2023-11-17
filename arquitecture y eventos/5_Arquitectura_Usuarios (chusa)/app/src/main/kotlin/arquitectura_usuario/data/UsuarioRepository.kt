package arquitectura_usuario.data

import arquitectura_usuario.data.mocks.UsuarioDaoMock
import com.example.ejemploarquitectura.models.Usuario


class UsuarioRepository {
    val proveedorUsuarios= UsuarioDaoMock()

    fun get():List<Usuario> = proveedorUsuarios.get().toUsuarios()
    fun get(login:String): Usuario?= proveedorUsuarios.get(login)?.toUsuario()
    fun insert(usuario: Usuario)=proveedorUsuarios.insert(usuario.toUsuarioMock())
    fun update(usuario: Usuario)
    {
        proveedorUsuarios.update(usuario.toUsuarioMock())
    }

}